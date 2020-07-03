# Set

## set<>

1. HashSet<>

   无序，增加元素，允许添加null，但不允许添加相同元素，通常自动去重

   ```
   //去重
   Set<String> set1 = new HashSet<>(list);  // 对list去重
   //判断标准 equals方法和hashcode方法(可以重写两种方法(同时重写)，达到预期效果)
   ```

2. TreeSet<>

   排序

   ```
   Set<类型> treeSet = new TreeSet<>();
   //该类型需要满足comparable接口，重写compareTo;
   // TreeSet<>会自动排序
   public int compareTo(User o){
   	return this.name.compare(o.name) // 正序
   	return o.name.compare(this.name) // 倒序
   }
   
   ```

3. LinkedHashSet<>

   会保证元素的插入顺序

   ```
   Set<类型> linkedSet = new LinkedHashSet<>();
   ```

## 遍历

1. 使用增强的for循环
2. 使用迭代器
3. 没有下标，因此无法使用fori



## Map

### HashMap<数据类型(key)，数据类型(value)>

key-value

键-值

键不允许重复，value可以重复

1. 对象名.put(key,value);// 增加对象

   ```
   Map<String, Integer> map = new HashMap<>();
   map.put("123", 123);
   ```

2. 对象名.get(key); // 获取key对象

   ```
   对象名.get(key); 
   //查找如果不存在，返回null
   ```

3. keySet() // 获取map中的所有key名称

   ```
   Set<String> strings = 对象名.keySet();
   ```

4. values();

   ```
   Collection<Ingeter> values = 对象.values();
   ```

5. entrySet();查找对应关系

   ```
   对象名.entrySet();
   ```

6. getOrDefault();//查询key,如果找不到，则返回给定的默认值

   ```
   对象名.getOrDeafault(key,defaultValue);
   ```

### TreeMap\<key，value\>

1. 根据名称排序

2. key必须实现Comparable接口

   ```
   Map<key,value> 变量名 = new TreeMap<>(Compare...)
   ```

   



