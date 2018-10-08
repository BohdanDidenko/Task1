package Task1.Task1_4.Controller;

import Task1.Task1_4.Model.Model;
import Task1.Task1_4.View.View;

public class Controller {
    private Model model = new Model();
    private View view = new View();

    public void run(){
        view.run(model);
    }
}
