package io.mosip.kernel.uingenerator.verticle;

import org.springframework.context.ApplicationContext;

import io.mosip.kernel.uingenerator.constant.UinGeneratorConstant;
import io.mosip.kernel.uingenerator.router.UinGeneratorRouter;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

/**
 * Verticle for Uin status update from ISSUED to ASSIGNED
 * 
 * @author Megha Tanga
 * @since 1.0.0
 *
 */
public class UinStatusUpdateVerticle extends AbstractVerticle {

	/**
	 * Field for UinGeneratorRouter
	 */
	private UinGeneratorRouter uinGeneratorRouter;

	/**
	 * Initialize beans
	 * 
	 * @param context
	 *            context
	 */
	public UinStatusUpdateVerticle(final ApplicationContext context) {
		uinGeneratorRouter = (UinGeneratorRouter) context.getBean("uinGeneratorRouter");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.vertx.core.AbstractVerticle#start(io.vertx.core.Future)
	 */
	@Override
	public void start(Future<Void> future) {
		System.out.println("===== Update UIN status===");
		vertx.createHttpServer().requestHandler(uinGeneratorRouter.createRouter(vertx))
				.listen(config().getInteger(UinGeneratorConstant.HTTP_PORT, 8080), result -> {
					if (result.succeeded()) {
						uinGeneratorRouter.checkAndGenerateUins(vertx);
						future.complete();
					} else {
						future.fail(result.cause());
					}
				});
	}

}
