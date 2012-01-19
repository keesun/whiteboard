package me.whiteship.board.modules.servlet.async;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Keesun Baik
 * To test this class, turn off all filters in web.xml.
 */
@WebServlet(value = "/stocks2", asyncSupported = true)
public class AsyncServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if(req.getDispatcherType() == DispatcherType.REQUEST) {
            final AsyncContext asyncContext = req.startAsync(req, res);
            asyncContext.getResponse().getWriter().println("Start");
            asyncContext.start(new StockPriceRunner(asyncContext));
        } else if(req.getDispatcherType() == DispatcherType.ASYNC) {
            Double price = (Double) req.getAttribute("price");
            String ticker = (String) req.getAttribute("ticker");
            res.getWriter().printf("ticker: %s, price: %.2f", ticker, price);
        }
    }

    private class StockPriceRunner implements Runnable {
        AsyncContext asyncContext;
        
        public StockPriceRunner(AsyncContext asyncContext) {
            this.asyncContext = asyncContext;
        }

        @Override
        public void run() {
            String ticker = "GOOG";
            Double price = YahooFinance.getPrice(ticker);

            asyncContext.getRequest().setAttribute("price", price);
            asyncContext.getRequest().setAttribute("ticker", ticker);
            asyncContext.dispatch();
        }
    }
}
