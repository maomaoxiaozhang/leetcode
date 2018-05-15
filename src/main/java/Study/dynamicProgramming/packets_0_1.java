package Study.dynamicProgramming;

import util.Packet;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by lenovo on 2017/9/28.
 * 0-1 背包问题
 * 状态转移方程：f[i, j] = max{f[i-1, j], f[i-1, j-wi]+vi}
 * 这里用的是深度优先遍历
 */
public class packets_0_1 {
    private static List<Integer> seq = new LinkedList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Packet> packets = new LinkedList<>();
        int read;
        System.out.println("请输入背包重量和价值（-1结束）：");
        while ((read = in.nextInt()) != -1){
            Packet packet = new Packet();
            packet.setW(read);
            read = in.nextInt();
            packet.setV(read);
            packets.add(packet);
        }
        for (int i = 0; i < packets.size(); i++)
            seq.add(0);
        System.out.println("请输入背包最大重量：");
        int sum = in.nextInt();
        int result = solution(sum, packets);
        System.out.println(seq + "\n" + result);
    }

    public static int solution(int sum, List<Packet> packets){
        if (sum <= 0 || packets.size() == 0){
            return 0;
        }else {
            Packet packet = packets.get(packets.size()-1);
            List<Packet> rest = packets.subList(0, packets.size()-1);
            int has = 0;
            //确保当前物品能够放入背包
            if (sum-packet.getW() >= 0)
                has = solution(sum-packet.getW(), rest) + packet.getV();
            int not = solution(sum, rest);

//            //存储位置
//            if (has > not){
//                seq.set(rest.size(), packet.getV());
//                solution(sum-packet.getW(), rest);
//            }else {
//                seq.set(rest.size(), 0);
//                solution(sum, rest);
//            }
//            return Math.max(has, not);
            if (has > not){
                seq.add(rest.size(), packet.getV());
                return has;
            }else {
                return not;
            }
        }
    }

}

