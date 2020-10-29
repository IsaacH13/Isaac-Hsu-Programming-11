public class Main {
    static int[] addEnd(int[] addDelArray){
        int[] newArray = new int[addDelArray.length + 1];
        for(int i = 0; i < newArray.length; i++){
            newArray[i] = i + 1;
        }
        return newArray;
    }

    static int[] removeEnd(int[] addDelArray){
        for(int i = 0; i < addDelArray.length - 1; i++){
            addDelArray[i] = i + 1;
        }
        return addDelArray;
    }

    static int[] insertMid(int[] insertArray){
        int[] newArray = new int[insertArray.length + 1];
        for(int i = 0; i < newArray.length; i++){
            newArray[i] = i + 1;
        }
        return newArray;
    }

    public static void main(String[] args) {
        int[] addDelArray = new int[5];
        int[] insertArray = new int[4];
        insertArray[0] = 1;
        insertArray[1] = 2;
        insertArray[2] = 4;
        insertArray[3] = 5;

        System.out.println("ORIGINAL ARRAY: value to be added or deleted from end");
        for(int i = 0; i < addDelArray.length; i++){
            addDelArray[i] = i;
            System.out.println(i + 1);
        }
        System.out.println("***********************************************************");
        System.out.println("ORIGINAL ARRAY: value to be inserted into middle");
        for(int i = 0; i < insertArray.length; i++){
            System.out.println(insertArray[i]);
        }
        System.out.println("***********************************************************");
        System.out.println("Value added to the end of original array:");
        for(int i = 0; i < addEnd(addDelArray).length; i++){
            System.out.println(addEnd(addDelArray)[i]);
        }
        System.out.println("***********************************************************");
        System.out.println("Value removed from end of original array:");
        for(int i = 0; i < removeEnd(addDelArray).length - 1; i++){
            System.out.println(removeEnd(addDelArray)[i]);
        }
        System.out.println("***********************************************************");
        System.out.println("Value inserted into middle of original array:");
        for(int i = 0; i < insertMid(insertArray).length; i++){
            System.out.println(insertMid(insertArray)[i]);
        }
    }
}
