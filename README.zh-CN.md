# Java Template for Spring Boot

Spring Boot 脚手架。

[![Website][website-image]][website-href]
[![License][license-image]](LICENSE)
[![EN doc][en-doc-image]](README.EN.md)
[![CN doc][cn-doc-image]](README.zh-CN.md)

[![Stargazers][star-image]][star-href]

[website-image]: https://img.shields.io/website-up-down-green-red/https/guruguru.cn.svg
[website-href]: https://guruguru.cn/
[license-image]: https://img.shields.io/github/license/jinsyin/template-java
[en-doc-image]: https://img.shields.io/badge/Document-English-blue.svg?style=socialflat-square
[cn-doc-image]: https://img.shields.io/badge/文档-中文-blue.svg?style=socialflat-square
[star-image]: https://starchart.cc/jinsyin/template-java.svg
[star-href]: https://starchart.cc/jinsyin/template-java

## 用法

```bash
# 设置项目名称
export NEW_PROJECT_NAME=<your_project_name>

# 克隆项目
git clone git@github.com:JinsYin/template-java.git $NEW_PROJECT_NAME
cd $$NEW_PROJECT_NAME
git checkout springboot
rm -rf .git

# 修改项目名称
# macOS: sed -i '' ...
sed -i "s|template-java|$NEW_PROJECT_NAME|g" pom.xml
sed -i "s|template-java|$NEW_PROJECT_NAME|g" README.EN.md
sed -i "s|template-java|$NEW_PROJECT_NAME|g" README.zh-CN.md

# 为项目设置第一语言，假设以中文为第一语言
mv README.zh-CN.md README.md
sed -i 's|README.zh-CN.md|README.md|g' README.md
sed -i 's|README.zh-CN.md|README.md|g' README.EN.md

# 修改 README（可选）

# 修改包路径
mv src/main/java/cn/guruguru/javatemplate/ src/main/java/cn/guruguru/javatemplate/<packagename>
mv src/test/java/cn/guruguru/javatemplate/ src/test/java/cn/guruguru/javatemplate/<packagename>

# 修改应用配置
sed -i "s|java-template|$NEW_PROJECT_NAME|g" src/main/resources/application.yaml

#（可选）通过 jenv 设置 Java 版本，默认版本是 `1.8`
jenv local 1.8

#（可选）更新 Maven Wrapper 为指定版本，默认是 `3.5.4`，可能因 Java 版本不同而不同
mvn -N wrapper:wrapper -Dmaven=3.5.4

# 重新初始化项目
git init
git add .
git cm ":tada: Begin a project"
```

## 开发

1. 启动服务：`./mvnw spring-boot:run` 或者开发工具启动
2. 验证服务：`curl http:/localhost:8080/greet/hello?person=Tom`

## 部署

```bash
# 打包
$ ./mvnw clean package

# 启动
$ java -jar target/java-template-0.0.1-SNAPSHOT.jar
```
