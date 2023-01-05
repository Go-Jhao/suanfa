package shangguigu.linkedlist;

import com.sun.glass.ui.Size;
import org.junit.Test;

public class SingleLinkedListDemo {
    @Test
    public void test(){
//        HeroNode a = new HeroNode(1,"sd","df");
//        HeroNode b = new HeroNode(2,"ssdd","sddf");
//
//        b = a;
//        System.out.println(b);
        HeroNode h = new HeroNode(2,"ssdd","sddf");
        HeroNode a = new HeroNode(1,"sd","df");
        HeroNode b = new HeroNode(3,"ssdd","sddf");
        h.next = a;
        a.next = b;

        reverseList(h);
        System.out.println("");


    }
    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建要给链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();


//        //加入
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);

        singleLinkedList.list();
        System.out.println("-----------------------------------------------");
        reverseList(singleLinkedList.getHead());
        singleLinkedList.list();

        //加入按照编号的顺序
//        singleLinkedList.addByOrder(hero1);
//        singleLinkedList.addByOrder(hero4);
//        singleLinkedList.addByOrder(hero2);
//        singleLinkedList.addByOrder(hero3);


//        HeroNode newHeroNode = new HeroNode(2, "小卢", "小尾巴");
//        singleLinkedList.updata(newHeroNode);
//        singleLinkedList.list();
//        System.out.println("-------------------删除后---------------------");
//        singleLinkedList.delete(4);
//        singleLinkedList.delete(4);

//        System.out.println(getLength(singleLinkedList.getHead()));
//        System.out.println("-----------------------------------------------");
//        System.out.println(finLastIndext(singleLinkedList.getHead(),4));

    }

    public static HeroNode finLastIndext(HeroNode head,int index){
        if (head.next == null){
            return null;
        }
        int size = getLength(head);
        if (index <= 0 || index > size){
            return null;
        }
        int cur = 0;
        HeroNode temp = head.next;
        while (true){
            if (cur == size - index){
                return temp;
            }else {
                temp = temp.next;
                cur++;
            }
        }
    }

    //获取到单链表的有效节点的个数（如果是带有头结点，不统计）
    public static int getLength(HeroNode head){
        if (head.next == null){
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null){
            length++;
            cur = cur.next;
        }
        return length;
    }

    //将链表反转
    public static void reverseList(HeroNode head){
        if (head.next == null || head.next.next == null){
            return;
        }
        //辅助指针 遍历原先节点
        HeroNode cur = head.next;
        HeroNode reverseHead = new HeroNode(0,"","");
        HeroNode next = null;
        //遍历原来的代码，每遍历一个节点，就将其取出，并放到新的链表中reverseHead的最前端
        while (cur != null){
            next = cur.next;//指向当前节点的下一个节点
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }

        head.next = reverseHead.next;
    }

}
//定义SingleLinkedLList 管理我们的英雄
class SingleLinkedList{
    //先初始一个头结点，头结点不要动，不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    public void setHead(HeroNode head) {
        this.head = head;
    }

    //添加节点到单向链表
    public void add(HeroNode heroNode){
        HeroNode temp = head;
        while (true) {
            if (temp.next == null){
                break;
            }else {
                temp = temp.next;
            }
        }
        temp.next = heroNode;
    }

    //第二种添加方式，根据英雄排名插入到指定位置
    public void addByOrder(HeroNode heroNode){
        //用一个temp节点帮找到添加的位置 前一个节点
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.no > heroNode.no){
                break;
            }else if (temp.next.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            System.out.printf("准备插入的英雄编号%d已经存在,不能加入\n",heroNode.no);
        }else{//插入到链表中，temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

    }

    //修改节点的信息
    public void updata(HeroNode newHeroNode){
        HeroNode temp = head.next;
        if (temp == null){
            System.out.println("链表为空");
            return;
        }
        while (true){
            if (temp == null) {
                System.out.println("输入的英雄不存在");
                return;
            }else if (newHeroNode.no == temp.no){
                temp.name = newHeroNode.name;
                temp.nickname = newHeroNode.nickname;
                return;
            }
            temp = temp.next;
        }
    }


    //删除
    //删除的节点没有引用指向,被垃圾回收器回收
    public void delete(int no){
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.next = temp.next.next;
        }else {
            System.out.printf("要删除的%d节点不存在\n",no);
        }
    }
    //显示链表[遍历]
    public void list() {
        //判断链表是否为空
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点，不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while(true) {
            //判断是否到链表最后
            if(temp == null) {
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将temp后移， 一定小心
            temp = temp.next;
        }
    }
}
//定义一个HeroNode
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;
    //构造器

    public HeroNode() {
    }

    public HeroNode(int hNo , String hName , String hNickname){
        this.name = hName;
        this.no = hNo;
        this.nickname = hNickname;
    }
    //重写tostring

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
