package win.techflowing.recursion;

/**
 * 递归算法实现汉诺塔
 */
public class HanoiTower {

    /**
     * 为了将第n个盘子从from移动到to，就得先将第n个盘子上面的第n-1盘子移动到inter上；
     * 同样的，要想将inter上的第n-1个盘子移动到to上，就得先将第n-2个盘子移动到from上
     */
    public void moveDish(int level, char from, char inter, char to) {
        if (level == 1) {
            System.out.println("从" + from + " 移动盘子" + level + " 号到" + to);
        } else {
            // n-1个盘，从 from 移动到 inter
            moveDish(level - 1, from, to, inter);
            // 移动n盘
            System.out.println("从" + from + " 移动盘子" + level + " 号到" + to);
            // n-1个盘，从 inter 移动到 to
            moveDish(level - 1, inter, from, to);
        }
    }

    /**
     * n个盘子的汉诺塔需要移动的次数
     * <p>
     * 当n = 1 时,count = 1;
     * 当n = 2 时,count = 3;
     * 当n = 3 时,count = 7;
     * 当n = 4 时,count = 15;
     * 根据以上可得表达式：
     * count(1) = 1
     * count(n) = 2*count(n)+1 (n>1）
     * 即n个盘子移动的次数表达式为：
     * count(n) = 2^n - 1 (n>0)
     *
     * @param n 盘子数
     */
    public int getCount(int n) {
        return (int) Math.pow(2, n) - 1;
    }

    public static void main(String[] args) {
        int diskCount = 12;
        HanoiTower tower = new HanoiTower();
        tower.moveDish(diskCount, 'A', 'B', 'C');
        System.out.println(tower.getCount(diskCount));
    }
}
