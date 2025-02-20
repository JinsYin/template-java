# template-java

采用 Maven 管理的 Java 项目模板。

[![Website][website-image]][website-href]
[![License][license-image]](LICENSE)
[![EN doc][en-doc-image]](README.EN.md)
[![CN doc][cn-doc-image]](README)

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
rm -rf .git

# 修改项目名称
# macOS: sed -i '' ...
sed -i "s|template-java|$NEW_PROJECT_NAME|g" pom.xml
sed -i "s|template-java|$NEW_PROJECT_NAME|g" README.EN.md
sed -i "s|template-java|$NEW_PROJECT_NAME|g" README.md

# 切换 Java 版本为 `1.8`
sdk use java 1.8

# 更新 Maven Wrapper 为指定版本（可选），默认是 `3.5.4`，可能因 Java 版本不同而不同
mvn -N wrapper:wrapper -Dmaven=3.5.4

# 重新初始化项目
git init
git add .
git cm ":tada: Begin a project"
```
