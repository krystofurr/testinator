package ca.pe.cjsigouin.testinator;

import ca.pe.cjsigouin.testinator.manager.SceneManager;
import ca.pe.cjsigouin.testinator.manager.SeleniumManager;
import java.util.Arrays;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main extends Application {

    private static final Logger log = LoggerFactory.getLogger(Main.class);
    private static ApplicationContext context;

    @Override
    public void start(final Stage stage) throws Exception {

        context = new AnnotationConfigApplicationContext(AppConfig.class);

        log.info(Arrays.toString(context.getBeanDefinitionNames()));
        
        SceneManager scenes = new SceneManager(stage);
        SeleniumManager selenium = new SeleniumManager();

        // Load selenium drivers
        SeleniumManager.loadDrivers();
        // Load scenes
        scenes.loadScenes();

        SceneManager.getStage().setTitle(AppConfig.TITLE_APP);
        SceneManager.getStage().setScene(SceneManager.getScenes().get(SceneConfig.SCENE_SPLASH));
        SceneManager.getStage().show();

        // Splash screen displays first and then the Intro scene
        Task<Void> sleeper = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try {
                    Thread.sleep(AppConfig.APP_SPLASH_SCREEN_PAUSE);
                } catch (InterruptedException e) {
                }
                return null;
            }
        };
        sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                stage.setScene(SceneManager.getScenes().get(SceneConfig.SCENE_INTRO));
            }
        });
        new Thread(sleeper).start();

    }

    public static ApplicationContext getContext() {
        return context;
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Launch application
        launch(args);
    }
}
