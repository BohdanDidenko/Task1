package Task1.Task1_3.Controller;

import Task1.Task1_3.Model.Model;
import Task1.Task1_3.View.View;

public class Controller {
    private Model model = new Model();
    private View view = new View();

    public void run(){
        view.run(model);
    }
}

