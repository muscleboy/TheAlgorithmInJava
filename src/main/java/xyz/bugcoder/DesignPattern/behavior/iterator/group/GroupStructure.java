package xyz.bugcoder.DesignPattern.behavior.iterator.group;

import xyz.bugcoder.DesignPattern.behavior.iterator.lang.Collection;
import xyz.bugcoder.DesignPattern.behavior.iterator.lang.Iterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Package: xyz.bugcoder.DesignPattern.behavior.iterator.group
 * @author: Weiyj
 * @Description: TODO
 * @createTime 2020-11-08 15:17
 */
public class GroupStructure implements Collection<Employee, Link> {

    private String groupId;                                                 // 组织ID，也是一个组织链的头部ID
    private String groupName;                                               // 组织名称
    private Map<String, Employee> employeeMap = new ConcurrentHashMap<String, Employee>();  // 雇员列表
    private Map<String, List<Link>> linkMap = new ConcurrentHashMap<String, List<Link>>();  // 组织架构关系；id->list
    private Map<String, String> invertedMap = new ConcurrentHashMap<String, String>();       // 反向关系链

    public GroupStructure(String groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }

    @Override
    public boolean add(Employee employee) {
        return employeeMap.put(employee.getUId(), employee) != null;
    }

    @Override
    public boolean remove(Employee employee) {
        return employeeMap.remove(employee.getUId()) != null;
    }

    @Override
    public boolean addLink(String k, Link link) {
        invertedMap.put(link.getToId(), link.getFromId());
        if (linkMap.containsKey(k)){
            return linkMap.get(k).add(link);
        }
        List<Link> links = new ArrayList<>();
        links.add(link);
        linkMap.put(k, links);

        return true;
    }

    @Override
    public boolean removeLink(String k) {
        return linkMap.remove(k) != null;
    }

    @Override
    public Iterator<Employee> iterator() {
        return new Iterator<Employee>() {

            HashMap<String, Integer> keyMap = new HashMap<>();
            int totalIdx = 0;
            private String fromId = groupId;
            private String toId = groupId;

            @Override
            public boolean hasNext() {
                return totalIdx < employeeMap.size();
            }

            @Override
            public Employee next() {
                List<Link> links = linkMap.get(toId);
                int cursor = getCursorId(toId);

                if (links == null){
                    cursor = getCursorId(fromId);
                    links = linkMap.get(fromId);
                }

                while (cursor > links.size() - 1){
                    fromId = invertedMap.get(fromId);
                    cursor = getCursorId(fromId);
                    links = linkMap.get(fromId);
                }

                Link link = links.get(cursor);
                toId = link.getToId();
                fromId = link.getFromId();
                totalIdx ++;

                return employeeMap.get(link.getToId());
            }

            private int getCursorId(String key){
                int index = 0;
                if (keyMap.containsKey(key)){
                    index = keyMap.get(key);
                    keyMap.put(key, ++index);
                }
                keyMap.put(key, index);

                return index;
            }

        };
    }


}
