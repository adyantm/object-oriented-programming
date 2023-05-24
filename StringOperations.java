
public class StringOperations {

    // part b

    public static void main(String[] args) {

        String name = "Adyant";
        System.out.println("original name = " + name);

        name = "a" + name.substring(1,name.length()-1) + "Z"; // did lower case "a" instead of "A" to show change in original String name
        System.out.println("new name = " + name);

        String website = "www.abercrombie.com";
        System.out.println("website url = " + website);

        String url = "www.nike.com";
        url = url.substring(4,8) + "1331";
        System.out.println("new url = " + url);

        if ( 6>3 )
        {
            int a = 0;
        }
        else
        {
            int b =0;
        }
    }


}
