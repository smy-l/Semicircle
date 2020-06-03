# git中一些操作
## 下载
`git clone`+git仓库的SSH地址<br>
结果：将git仓库下载到当前文件夹下

## 上传
### 单个仓库
```
git status             //查看修改
git add .              //将所有更改添加(.可以更改为单个文件名)
git commit -m "注释"    //将变更固定，添加描述语句
git push               //同步到服务器
```

### 多个仓库
```
git status
git add .
git commit -m "注释"
git push 仓库名称 分支

```

## git仓库
### 查看本地文件中有哪些git仓库
```
git remote -v
```

### 本地文件增加\删除git中仓库
```
git remote add 仓库名称 仓库地址
git remote remove 仓库名称
```

## 提交文件后，更改 .gitignore 文件
```
git rm -r --cache .
git add .
git commit -m "new .gitignore"
git push
```

## git命令回显中文出现乱码
```
git config --global core.quotepath false
```

## 查看是否有.git文件夹
```
ls -al | grep "\.git"

rm -rf .git  //非自己的，删除
```

## 修改自己提交的git用户名和邮箱
```
git config --ilst //显示当前用户名和邮箱
git config --global user.name "你的名字，使用英文字母"
git config --gloval user.name "邮箱地址"
```





