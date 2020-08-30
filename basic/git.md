# git中一些操作

## 安装git

下载安装文件，安装（一路next）

### 配置环境变量

在path中添加三条路径(windows)

1. `D:\Git\bin`
2. `D:\Gitmingw64libexec\git-core`
3. `D:\Git\mingw32\bin`

### 生成SSH密钥

1. 打开Git Bash软件
2. 键入命令：`ssh-keygen -t rsa -C "xxx@email.com"` "xxx@email.com"即当前githab中包含的用户email
3. 显示内容让你输入key的名称，默认回车即可，可以输入名称如id_rsa等，一般默认就行（一直回车）；
4. 在C:\Users\管理员用户\.ssh\下产生两个文件：id_rsa和id_rsa.pub
5. 用记事本打开id_rsa.pub文件，复制内容，粘贴在公司的git库的ssh密钥管理界面，添加新公钥，内容粘贴内容粘贴刚才复制的内容，github也同样适用。

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


## 提升github下载/上传速度(似乎没什么用)

1. mac终端执行`sudo vim /etc/hosts`<br>
   windows终端进入*C:\Windows\System32\drivers\etc*修改hosts文件

2. 浏览器访问**https://www.ipaddress.com**，分别输入`github.com`和`github.global.ssl.fastly.net`获取对应ip，将其添加在hosts文件后<br>
   例(banyuanMac)：<br>

    ```
    140.82.112.3 github.com
    199.232.69.194 github.global.ssl.fastly.net
    ```

   例如(MyWin10):<br>

    ```
    140.82.112.4 github.com	
    199.232.69.194 github.global.ssl.fastly.net
    ```

3. 终端执行

   ```
   sudo killall -HUP mDNSResponder //刷新DNS缓存(mac)
   或
   ipconfig /flushdns //刷新DNS缓存(windows)
   ```

## 强行pull

```
git reset HEAD --hard
```
