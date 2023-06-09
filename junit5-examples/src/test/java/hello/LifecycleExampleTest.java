package hello;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import io.vertx.core.Vertx;
import io.vertx.junit5.VertxExtension;
import io.vertx.junit5.VertxTestContext;

@ExtendWith(VertxExtension.class)
class LifecycleExampleTest {

    @BeforeEach
    @DisplayName("Deploy a verticle")
    void prepare(Vertx vertx, VertxTestContext testContext) {
        vertx.deployVerticle(new SampleVerticle(), testContext.completing());
    }

    @Test
    @DisplayName("A first test")
    void foo(Vertx vertx, VertxTestContext testContext) {
        // (...)
        testContext.completeNow();
    }

    @Test
    @DisplayName("A second test")
    void bar(Vertx vertx, VertxTestContext testContext) {
        // (...)
        testContext.completeNow();
    }

    @AfterEach
    @DisplayName("Check that the verticle is still there")
    void lastChecks(Vertx vertx) {
        assertThat(vertx.deploymentIDs()).isNotEmpty().hasSize(1);
    }
}
