package shangguigu.linkedlist;

/**
 * @BelongsProject: suanfa
 * @BelongsPackage: shangguigu.linkedlist
 * @Author: GuoJHao
 * @CreateTime: 2022-11-10  13:42
 * @Description: TODO
 * @Version: 1.0
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        // 创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();

        // 修改
        HeroNode2 newHeroNode = new HeroNode2(4, "公孙胜", "入云龙");
        doubleLinkedList.updata(newHeroNode);
        System.out.println("修改后的链表情况");
        doubleLinkedList.list();

        // 删除
        doubleLinkedList.delete(3);
        System.out.println("删除后的链表情况~~");
        doubleLinkedList.list();
    }
}

class DoubleLinkedList{
    private HeroNode2 head = new HeroNode2(0, "", "");
    //返回头结点

    //添加节点到单向链表
    public void add(HeroNode2 heroNode){
        HeroNode2 temp = head;
        while (true) {
            if (temp.next == null){
                break;
            }else {
                temp = temp.next;
            }
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    //修改节点的信息
    public void updata(HeroNode2 newHeroNode){
        HeroNode2 temp = head.next;
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
        HeroNode2 temp = head;
        boolean flag = false;
        while (true){
            if (temp == null){
                break;
            }
            if (temp.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.pre.next = temp.next;
            if (temp.next!=null){
                temp.next.pre = temp.pre;
            }
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
        HeroNode2 temp = head.next;
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

class HeroNode2{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;

    //构造器
    public HeroNode2() {
    }

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
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