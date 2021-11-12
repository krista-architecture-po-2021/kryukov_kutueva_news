import io.undertow.Undertow;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class WebApplication extends Application {

    public static void main(String[] args) {
        startWebServer();
    }

    @Override
    public Set<Object> getSingletons() {
        Set<Object> resources = new HashSet<>();
        resources.add(new Reader());
        return resources;
    }


    private static void startWebServer() {
        Undertow.Builder builder = Undertow.builder().addHttpListener(8080, "localhost");
        UndertowJaxrsServer server = new UndertowJaxrsServer().start(builder);
        server.deploy(WebApplication.class);
        System.out.println("Сервер запущен http://localhost:8080/");
    }
}
