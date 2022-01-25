package TestPartition;

public class CreateString {
    private String strForTesting ="";
    private String str = "";
    private String temp = "";

    public String createTest(int start, int end){
        for(int i = start; i<=end ; i++){
            str = '"'+"test" + i + '"';
            temp = str+",";
            strForTesting = temp + strForTesting;
        }
        return strForTesting;
    }

    public static void main(String[] args) {
        CreateString cs = new CreateString();
        String haha = null;
        haha = cs.createTest(1,25);
        System.out.println(haha);
    }

}
