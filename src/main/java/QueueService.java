import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QueueService implements Service {

    ConcurrentHashMap<String, ConcurrentLinkedQueue<String>> map = new ConcurrentHashMap();

    @Override
    public Resp process(Req req) {
        String text = "";
        int status = 200;
        String nameQueue = "WEATHER";
        //String nameParam = "TEMPERATURE";
        map.putIfAbsent(nameQueue, new ConcurrentLinkedQueue<String>());
        if (req.method().toUpperCase().equals("POST")) {
            //map.get(nameQueue).add(req.valueOf(nameParam));
            map.get(nameQueue).add(req.getText());
            text = req.getText() + " : OK";
//            text = req.valueOf(nameParam);
//            if (text == null || text.equals("")) {
//                status = 999;
//                text = "";
//            }

        } else if (req.method().toUpperCase().equals("GET")) {
            text = map.get(nameQueue).poll();
            if (text == null || text.equals("")) {
                status = 999;
                text = "not date";
            }
        }
        Resp resp = new Resp(text, status);
        return resp;
    }
}
