import io.undertow.Undertow;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;

import java.util.HashSet;
import java.util.Set;

public class Application {
    private static void startWebServer() {
        Undertow.Builder builder = Undertow.builder().addHttpListener(8080, "localhost");
        UndertowJaxrsServer server = new UndertowJaxrsServer().start(builder);
        server.deploy(WebApplication.class);
    }

    public Set<Object> getSingletones() {
        Set<Object> resources = new HashSet<>();
        resources.add(new Reader());
        return resources;
    }
}
