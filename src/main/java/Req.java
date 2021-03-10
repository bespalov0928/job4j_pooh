
public class Req {
    private final String text;


    public Req(String text) {
        this.text = text;
    }

    public String valueOf(String key) {
        String str = "";
        String[] arrFirst = text.toUpperCase().split(key);
        if (arrFirst.length < 2) {
            return str;
        }
        str = arrFirst[1];
        str = str.replace("=", "");
        str = str.replace(" ", "");
        return str;
    }

    /**
     * queue, topic
     *
     * @return
     */
    public String mode() {

        String str = "";
        String textTemp = text.replace(" ", "");
        String[] arrFirst = textTemp.split("\r\n");
        if (arrFirst.length == 0) {
            return "";
        }
        str = arrFirst[0];
        String[] arrSecond = str.split("/");
        if (arrSecond.length == 0) {
            return "";
        }
        str = arrSecond[1];
//        String[] arrFirst = text.split(" ");
//        if (arrFirst.length < 2) {
//            return str;
//        }
//        String strFirst = arrFirst[1];
//        //System.out.println("strTmp:" + strFirst);
//
//        String[] arrSecond = strFirst.split("/");
//        if (arrSecond.length < 2) {
//            return str;
//        }
//        str = arrSecond[1];
        return str;

    }

    /**
     * get, post
     *
     * @return
     */
    public String method() {

        String str = "";
        String[] arrFirst = text.split(" ");
        if (arrFirst.length < 2) {
            return str;
        }
        str = arrFirst[0];
        return str;

    }

    /**
     * weather
     *
     * @return
     */
    public String nameQueue() {
        String str = "";
        String[] arrFirst = text.split(" ");
        if (arrFirst.length < 2) {
            return str;
        }
        String strFirst = arrFirst[1];
        //System.out.println("strTmp:" + strFirst);

        String[] arrSecond = strFirst.split("/");
        if (arrSecond.length < 2) {
            return str;
        }
        str = arrSecond[2];
        return str;

    }

    public String nameParam() {
        String str = "";
        return str;
    }

    public String getText() {
        return text;
    }
}
