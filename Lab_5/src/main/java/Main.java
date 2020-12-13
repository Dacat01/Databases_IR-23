import com.hamal.view.MyView;
import com.hamal.persistance.SessionManager;



public class Main {

    public static void main(final String[] args) throws Exception {
        SessionManager.openSessionFactory();
        new MyView().show();
        SessionManager.closeSessionFactory();
    }
}