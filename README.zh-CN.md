# java-template

采用 Maven 管理的 Java 项目模板。

[![Website][website-image]][website-href]
[![License][license-image]][license-href]
[![EN doc][en-doc-image]](README.EN.md)
[![CN doc][cn-doc-image]](README.zh-CN.md)

[![Stargazers][star-image]][star-href]

[website-image]: https://img.shields.io/website-up-down-green-red/https/datagov.cn.svg
[website-href]: https://datagov.cn/
[license-image]: https://img.shields.io/github/license/jinsyin/java-template
[license-href]: https://github.com/jinsyin/java-template/blob/master/LICENSE
[en-doc-image]: https://img.shields.io/badge/Document-English-blue.svg?style=socialflat-square
[cn-doc-image]: https://img.shields.io/badge/文档-中文-blue.svg?style=socialflat-square
[star-image]: https://starchart.cc/jinsyin/java-template.svg
[star-href]: https://starchart.cc/jinsyin/java-template

## 用法

```bash
git clone git@github.com:JinsYin/java-template.git <project_name>
cd <project_name>
rm -rf .git
# macOS: sed -i '' ...
sed -i 's|java-template|<project_name>|g' pom.xml
sed -i 's|java-template|<project_name>|g' README.EN.md
sed -i 's|java-template|<project_name>|g' README.zh-CN.md
# 为项目设置第一语言，以中文为例
mv README.zh-CN.md README.md
sed -i 's|README.zh-CN.md|README.md|g' README.md
sed -i 's|README.zh-CN.md|README.md|g' README.EN.md
```
