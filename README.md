# scoa

简单易懂的面向对象架构：simple comprehensible object-oriented
architecture，旨在提供一个简单的微服务分包设计，让微服务开发的代码结构更加清晰明了，本项目是一个maven骨架项目，需本地编译后使用。

## 使用说明

### 编译骨架

#### 手动构建

在根目录直接执行如下命令：

```shell
# 构建骨架
mvn archetype:create-from-project
# 进入骨架项目
cd target/generated-sources/archetype
# 本地编译骨架
mvn install
```

此时骨架项目已经在本地编译完成

#### 基于已构建好了的

骨架项目已上传github，并定期更新，参照 https://github.com/egd-prodigal/scoa-archetype ，直接拉取scoa-archetype代码，本地编译即可:

```shell
# 拉取项目
git clone git@github.com:egd-prodigal/scoa-archetype.git
# 进入工程目录
cd scoa-archetype
# 本地编译骨架
mvn install
```

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

如下图所示：
![images](https://yeemin.site/scoa/archetype-generate.png)
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

### 功能模块结构

功能应用结构如下图所示，包括提供业务接口能力的facade、业务功能逻辑实现app、微服务接口声明client、模型模块model、基础设施模块infrastructure。
![images](https://yeemin.site/scoa/scoa.png)
骨架自动生成的项目包含一个starter模块，依赖facade模块，提供SpringBoot的启动方法，用以启动单功能服务应用。

### 包结构

骨架生成的各个模块的包路径如下所示：
![images](https://yeemin.site/scoa/package.png)
每个包的里的代码功能说明（仅列出部分可能存在的包，按业务以及技术需求酌情调整）：
<table>
<thead>
<tr>
<td>模块名</td>
<td>包名</td>
<td>包说明</td>
</tr>
</thead>
<tbody>
<tr>
<td rowspan="3">facade</td>
<td>web</td>
<td>提供给网页的后端接口入口</td>
</tr>
<tr>
<td>app</td>
<td>提供给APP的后端接口入口</td>
</tr>
<tr>
<td>mimiapp</td>
<td>提供给小程序的后端接口入口</td>
</tr>
<tr>
<td rowspan="2">client</td>
<td>api</td>
<td>微服务接口定义</td>
</tr>
<tr>
<td>dto</td>
<td>微服务接口的参数定义</td>
</tr>
<tr>
<td rowspan="7">app</td>
<td>command/query</td>
<td>查询器包，具体执行查询的类，类名以QueryExe结尾</td>
</tr>
<tr>
<td>command/exe</td>
<td>执行器包，具体执行业务操作的类，类名以CmdExe结尾</td>
</tr>
<tr>
<td>converter</td>
<td>转换器包，存放特殊的POJO转换工具类，类名以Converter结尾</td>
</tr>
<tr>
<td>listener</td>
<td>监听器包，存放如spring event的监听器、kafka等消息组件的监听器等类，类名以Listener结尾</td>
</tr>
<tr>
<td>provider</td>
<td>微服务包，微服务接口实现类，类名以Provider结尾</td>
</tr>
<tr>
<td>service</td>
<td>业务服务接口包，定义接口以及接口方法，类名以Service结尾</td>
</tr>
<tr>
<td>service/impl</td>
<td>业务服务实现包，存放具体的业务逻辑类，集成command包下的各个具体查询器和执行器，类名以ServiceImpl结尾</td>
</tr>
<tr>
<td rowspan="4">model</td>
<td>domain</td>
<td>领域对象包，存放领域对象定义，一般定义抽象类</td>
</tr>
<tr>
<td>factory</td>
<td>领域对象工厂包，领域对象创建方式，框架提供通用的方法，这个包里存放领域单独定义的工厂类，类名以Factory结尾</td>
</tr>
<tr>
<td>vo</td>
<td>存放展示层使用的类，类名一般以VO结尾</td>
</tr>
<tr>
<td>dto</td>
<td>存放数据传输对象，类名一般以DTO结尾</td>
</tr>
<tr>
<td rowspan="8">infrastructure</td>
<td>config</td>
<td>存放基础设施配置类，包括数据库配置、各种orm配置、搜索引擎配置、消息队列配置、大数据服务配置等</td>
</tr>
<tr>
<td>domain/object</td>
<td>具体领域对象，继承model模块的domain包里的抽象类，具体领域对象应以spring bean存在，并且scope为prototype</td>
</tr>
<tr>
<td>event</td>
<td>定义具体spring event事件的类，消息队列等其他基础设施的类也可以放这个包，或者单独定义一个message的包</td>
</tr>
<tr>
<td>repository/entity</td>
<td>数据源对象包，存放数据库表映射的实体类，类名一般以PO结尾</td>
</tr>
<tr>
<td>repository/mapper</td>
<td>mybatis数据访问层的接口包，存放各个Mapper接口类</td>
</tr>
<tr>
<td>repository/dao</td>
<td>其他如JDBC等访问数据库的包接口定义，类名一般以Dao结尾</td>
</tr>
<tr>
<td>repository/dao/impl</td>
<td>其他如JDBC等访问数据库的包接口实现，类名一般以DaoImpl结尾</td>
</tr>
<tr>
<td>util</td>
<td>工具类包，存放当前基础设施/领域的工具类</td>
</tr>
</tbody>
</table>
### 微服务应用架构
每个业务功能原则上都应以独立的架构存在，多个业务功能可以基于同一个应用部署，服务由业务模块提供，但服务能力由运行的应用承载，因此，在一个集成多业务的系统应用，代码结构应该如下所示：
![images](https://yeemin.site/scoa/scoa-starter.png)
starter模块可以依赖facade模块以提供业务接口能力，也可以直接依赖app模块以仅提供微服务provider的能力。
### 业务系统公共依赖
在一个完整的业务系统里，必然存在相对"底层"的模型，或者一些相对公共的模型，在这种情况下，一定存在业务功能依赖公共方法的需求，在这个架构里，应当由底层公共能力编写者提供model和infrastructure模块给业务功能开发者直接调用，业务功能模块的app直接依赖这两个模块：
![images](https://yeemin.site/scoa/scoa-dependency.png)
## 微服务调用
本架构提供了client模块用以定义微服务接口能力，其实现在app模块的provider包里，而其他微服务调用时，因也在app模块里调用，微服务调用示意图如下：
![images](https://yeemin.site/scoa/scoa-rpc.png)

> 本人在编写scoa-rpc，以提供遵循如上微服务体系规则的微服务rpc能力，敬请期待。

## 样例说明

我以三国演义里“关羽诛颜良”为例，编写这个架构样例，每次构建项目，也会自动创建了这个样例。

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



