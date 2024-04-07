# java-template

Java project template with maven.

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

## Usages

```bash
git clone git@github.com:JinsYin/java-template.git <project_name>
cd <project_name>
rm -rf .git
# macOS: sed -i '' ...
sed -i 's|java-template|<project_name>|g' pom.xml
sed -i 's|java-template|<project_name>|g' README.EN.md
sed -i 's|java-template|<project_name>|g' README.zh-CN.md
# set the primary language for the document, e.g. zh-CN
mv README.zh-CN.md README.md
sed -i 's|README.zh-CN.md|README.md|g' README.md
sed -i 's|README.zh-CN.md|README.md|g' README.EN.md
```
