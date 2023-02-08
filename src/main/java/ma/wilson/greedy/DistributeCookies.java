package ma.wilson.greedy;

import java.util.Arrays;

/**
 * 455.假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * <p>
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。
 * 如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * <p>
 * 示例 1:
 * <p>
 * 输入: g = [1,2,3], s = [1,1]
 * 输出: 1
 * 解释:
 * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 * 所以你应该输出1。
 * 示例 2:
 * <p>
 * 输入: g = [1,2], s = [1,2,3]
 * 输出: 2
 * 解释:
 * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 * 所以你应该输出2.
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= g.length <= 3 * 104
 * 0 <= s.length <= 3 * 104
 * 1 <= g[i], s[j] <= 231 - 1
 *
 * @author: Wilson ma
 **/
public class DistributeCookies {

    public static void main(String[] args) {
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        int contentChildren = findContentChildren(g, s);
        System.out.println(contentChildren);
    }


    public static int findContentChildren(int[] g, int[] s) {
        // 首先先对g和s进行排序
        Arrays.sort(g);
        Arrays.sort(s);
        // 需要设置一个下标，当第j个饼干满足第i个小孩子时，记录饼干下标，下次判断从j+1个饼干判断
        int index = 0;
        // 统计满足的小孩子个数
        int count = 0;
        for (int i = 0; i < g.length; i++) {
            for (int j = index; j < s.length; j++) {
                if (g[i] <= s[j]) {
                    index++;
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static int findContentChildren1(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int start = 0;
        int count = 0;
        for (int i = 0; i < s.length && start < g.length; i++) {
            if (s[i] >= g[start]) {
                start++;
                count++;
            }
        }
        return count;
    }
}
