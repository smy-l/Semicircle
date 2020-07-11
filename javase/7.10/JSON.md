# Json

1. 把类对象序列化Json字符串

   ```
   User user = new User("张三", "123456");
   
   String s = JSONObject.toJSONString(User);
   ```

2. 或者把Json字符串转换成类对象

   ```
   String str = "{\"name\":\"张三\",\"password\":\"123456\"}";
   
   //转换，默认转成Object对象
   Object user = JSONObject.parseObject(str);
   
   // 转换，User.class 为提示系统转成User类的对象
   // 如果不给，之后也无法进行向下转型
   User user = JSONObject.parseObject(str,User.class);
   
   ```

3. Json字符串转换成对象的数组

4. ```
   JSONObject.parseArray(stringBuiler.toString(), Video.class);
   ```

   

5. 转换方式是根据Getter方法

   使用JSON转换，就不需要实现`Serializable`接口

json文件中信息格式

```
[

]
	{
		"name": "张三",
		"password": "123456",
		"number": 1,
		"boolean": true;
		"Object": {
	 	"prop": "value",
		},
	
		"arr": [
			"",
			1,
			true,
			{},
			[]
		]
	}
]
```

