package app;

import app.controllers.PingController;
import app.controllers.TransactionsController;
import app.dataSources.TransactionsData;
import app.services.TransactionsService;
import io.jooby.Jooby;
import io.jooby.json.GsonModule;

public class Router extends Jooby {

  {
    install(new GsonModule());
    configureRoutes();
  }

  public static void main(final String[] args) {
    runApp(args, Router::new);
  }

  private void configureRoutes() {
    mvc(new PingController());
    mvc(new TransactionsController(new TransactionsService(getInstanceTransactionData())));
  }


  private TransactionsData getInstanceTransactionData(){
    return new TransactionsData();
  }
}
