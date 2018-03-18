package domain;

public class LinkSingleNode {
    public int value;
    public LinkSingleNode next;

    public LinkSingleNode(int value){
        this.value = value;
    }

    public LinkSingleNode addNodeToEnd(int value){
        return addNodeToEnd(new LinkSingleNode(value));
    }

    public LinkSingleNode addNodeToEnd(LinkSingleNode addNode){
        LinkSingleNode tmpNext  = this;
        while (tmpNext!=null && tmpNext.next!=null){
            tmpNext = tmpNext.next;
        }
        tmpNext.next = addNode;
        return addNode;
    }
}
