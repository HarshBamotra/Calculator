public class test {
    public String s;

    public test(String se){
        s=se;
    }

    public void findResult(){
        String arr[] = s.split(",");
        for(int i=0 ; i<arr.length ; i++){
            System.out.println("," + arr[i] + ",");
        }
    }

    public static void main(String[] args) {
        test obj = new test(",-,1");
        obj.findResult();
    }
}
