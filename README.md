# scoa-sample
scoa架构样例


## 使用说明
### 编译骨架
#### 手动构建
在根目录直接执行如下命令：
```shell
# 构建骨架
mvn archetype:create-from-project
# 进入骨架项目
cd target/generated-sources/archetype
# 编译骨架
mvn install
```
此时骨架项目已经在本地编译完成
#### 基于已构建好了的
骨架项目已上传github，参照 https://github.com/egd-prodigal/scoa-archetype ，直接拉取scoa-archetype代码，本地mvn install一下即可。
### 基于骨架构建
#### 交互模式
在新建项目的目录里执行如下命令：
```shell
mvn archetype:generate -DarchetypeCatalog=local
```
交互命令将会按顺序要求输入如下信息：
1. 在本地的骨架项目中选择scoa-archetype，输入序号
2. 输入groupId
3. 输入artifactId
4. 输入version
5. 输入默认公共包名
6. 交互窗口显示已输入的内容，并要求确认，输入Y表示确认  

构建成功，项目已成功创建，打开项目会发现项目是一个完整的scoa结构。
#### 命令模式
骨架编译完成后，打开本地仓库目录，把 **io/github/egd-prodigal/scoa-archetype** 目录复制到 **org/apache/maven/archetypes** 里，可通过如下命令执行：
```shell
cp -r io/github/egd-prodigal/scoa-archetype org/apache/maven/archetypes
```
然后在新建项目的目录里执行如下脚本：
```shell
mvn archetype:generate -DgroupId=你的GroupId -DartifactId=你的ArtifactId -Dversion=你的Version -DarchetypeArtifactId=scoa-archetype -DinteractiveMode=false
```
项目自动创建完成。

> 本项目也是源于示例项目生成的骨架创建而成

## 模块结构
![images](https://yeemin.site/scoa/scoa.png)

## 样例说明
我以三国演义里“关羽诛颜良”为例，编写这个架构样例。  

### 模型设计
历史由人演绎，所有行为都由人产生，因此必然存在一个基础的类：人，命名为People，暂定每个人都拥有姓、名、字，生卒年，鉴于本例人数较少，所以仅用姓名字做唯一索引。  
东汉末年军阀割据，产生了各个阵营，此时关羽在曹操阵营，颜良在袁绍阵营。此时产生了一个名词：阵营，使用一个类：Camp来表示，阵营拥有一个主公、无数将领和无数士兵，本例忽略士兵。  
因此，从人物的角色上，有了主公、将领，分别用Lord和General，而不管是曹操、关羽还是颜良，都是战争的参与者，都是战士，使用新的类：Warrior来定义战士的行为。  
本例仅从关羽诛颜良的例子讲述，因此我们给战士定义如下行为：
- 杀敌将领：kill(enemy)
- 对白: speak(worlds)  

由于主公，不上阵杀敌，因此主公的杀敌将领的方法将会抛出异常。将领归属阵营，因此将领也拥有阵营属性。  
除了创造历史的人物，历史还需被记载，因此我们需要一个记载历史的东西，我们通过事件发布的方式让历史事件故事从事件本身中剥离出来，让史官能够不参与而能记载历史。
### 数据库设计
本例力求简洁，因此只按需求创建三张表：
此样例中的模型都是以人为单位，因此数据库仅需一张表：people，并且只需要姓、名、字，生、卒年五个字段，所谓关羽斩颜良，从数据角度，仅仅是颜良拥有了卒年这一属性，因此创建如下表：  
|字段|格式|说明|
|----|----|----|
|firstName|String|姓|
|lastName|String|名|
|styleName|String|字|
|birth|String|生于|
|dead|String|卒于|

军事行动必然存在对立双方，我们以阵营为模型，创建表camp，阵营也是由人构成，因此我们把这张表用作阵营里的人，忽略阵营这一实体，这个例子里，阵营只有主公：lord、将领：general，阵营也是由人组成，且阵营按主公区分，且人都有职位，因此创建如下表：
|字段|格式|说明|
|----|----|----|
|lord|String|主公|
|firstName|String|姓|
|lastName|String|名|
|styleName|String|字|
|official|String|职位|

历史事件需有记载方可被后人知晓，历史由史官记载，史官记载历史皆因历史发生了，史书是记录历史的媒介，这里我们只记录发生年份以及事件名称，因此建立如下表：
|字段|格式|说明|
|----|----|----|
|reign_title|String|年号|
|history|String|历史事件|



