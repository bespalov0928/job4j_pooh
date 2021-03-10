import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TopicService implements Service {
    ConcurrentHashMap<String, ConcurrentLinkedQueue<String>> map = new ConcurrentHashMap();


    @Override
    public Resp process(Req req) {
        String text = "";
        int status = 200;
        String nameQueue = "WEATHER";
        map.putIfAbsent(nameQueue, new ConcurrentLinkedQueue<String>());
        if (req.method().toUpperCase().equals("POST")) {
            map.get(nameQueue).add(req.getText());
            text = req.getText() + " : OK";

        } else if (req.method().toUpperCase().equals("GET")) {
            ConcurrentLinkedQueue<String> linkUser = new ConcurrentLinkedQueue<String>();
            //LinkedList<String> linkUser = new LinkedList<>();
            //map.get(nameQueue).addAll(linkUser);
            linkUser.addAll(map.get(nameQueue));
            text = linkUser.poll();
            if (text == null || text.equals("")) {
                status = 999;
                text = "not date";
            }

        }
        Resp resp = new Resp(text, status);
        return resp;
    }
}
