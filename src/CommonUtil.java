public class CommonUtil {
    public static int getNumberOfMaximumKey(int minimumDegree){
        return 2 * minimumDegree - 1;
    }

    public static int getNumberOfMaximumChildren(int minimumDegree){
        return 2 * minimumDegree;
    }

    public static int getNumberOfMinimumKeyInANode(int minimumDegree){
        return minimumDegree - 1;
    }
}
