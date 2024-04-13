# java-template

Java project template with maven.

[![Website][website-image]][website-href] 
[![License][license-image]](LICENSE)
[![EN doc][en-doc-image]](README.EN.md)
[![CN doc][cn-doc-image]](README.zh-CN.md)

[![Stargazers][star-image]][star-href]

[website-image]: https://img.shields.io/website-up-down-green-red/https/guruguru.cn.svg
[website-href]: https://guruguru.cn/
[license-image]: https://img.shields.io/github/license/jinsyin/java-template
[en-doc-image]: https://img.shields.io/badge/Document-English-blue.svg?style=socialflat-square
[cn-doc-image]: https://img.shields.io/badge/文档-中文-blue.svg?style=socialflat-square
[star-image]: https://starchart.cc/jinsyin/java-template.svg
[star-href]: https://starchart.cc/jinsyin/java-template

## Usages

```bash
# set project name
export NEW_PROJECT_NAME=<your_project_name>

# clone the project
git clone git@github.com:JinsYin/java-template.git $NEW_PROJECT_NAME
cd $NEW_PROJECT_NAME
rm -rf .git

# update project name
# macOS: sed -i '' ...
sed -i "s|java-template|$NEW_PROJECT_NAME|g" pom.xml
sed -i "s|java-template|$NEW_PROJECT_NAME|g" README.EN.md
sed -i "s|java-template|$NEW_PROJECT_NAME|g" README.zh-CN.md

# set the primary language for the document, e.g. EN
mv README.EN.md README.md
sed -i 's|README.EN.md|README.md|g' README.md
sed -i 's|README.EN.md|README.md|g' README.zh-CN.md

# update the README

# update java version (optional)
jenv local 1.8

# update version of the maven wrapper (optional)
mvn -N wrapper:wrapper -Dmaven=3.5.4

# begin a git project
git init 
git add .
git cm ":tada: Begin a project"
```
