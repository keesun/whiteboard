package me.whiteship.board.modules.servlet.async;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author Keesun Baik
 * To test this class, turn off all filters in web.xml.
 */
@WebServlet(value = "/stocks", asyncSupported = true)
public class AsyncServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        final AsyncContext asyncContext = req.startAsync(req, res);
        asyncContext.getResponse().getWriter().println("Start");
        asyncContext.start(new StockPriceRunner(asyncContext));
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
            try {
                asyncContext.getResponse().getWriter().printf("ticker: %s, price: %.2f", ticker, price);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                asyncContext.complete();
            }
        }
    }
}
