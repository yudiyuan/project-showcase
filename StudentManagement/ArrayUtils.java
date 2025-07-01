package StudentManagement;

public class ArrayUtils {
//工具类构造私有

    private ArrayUtils() {
    }


    //并不是每一个类都要有成员变量的 可以只有方法
    //因为构造私有 所以所有的成员都是静态的

    public static int findIndexById(Student[] students, int id, int count) {

        for (int i=0;i<count;i++) {
            if (id == students[i].getId()) {
                //想要得到索引 那这个i就是这个id在对象数组中的索引
                return i;
            }
        }

        return -1;

    }
}
