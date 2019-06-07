主要是 commit  message 提交规范，提交 commit message 的时候直接执行 `git commit`，这时候会直接打开一个终端编辑器（如果想用 vim 替换默认的编辑器的话，执行 `git config --global core.editor vim` ），看到如下内容：

> 尽量都用 English

```
# Type(<scope>): <subject>
# type 表示提交类型，subject 是一个简短的描述

# <body>
# 这里详细介绍这次提交
# 然后列举一些要点

# <footer>
# 这里是 Issue 相关的，一般是打开/关闭 Issue 

# Type should be one of the following:
# * feature (new feature)
# * fix (bug fix)
# * performance (some performance improvement such as CPU and memory usage)
# * docs (changes to documentation)
# * style (formatting, missing semi colons, etc; no code change)
# * refactor (refactoring production code)
# * test (adding missing tests, refactoring tests; no production code change)
# * chore (updating grunt tasks etc; no production code change)
# * rollback (rollback to a previous version)
# Scope is just the scope of the change. Something like (admin) or (teacher).
# Subject should use impertivite tone and say what you did.
# The body should go into detail about changes made.
# The footer should contain any JIRA (or other tool) issue references or actions.
```