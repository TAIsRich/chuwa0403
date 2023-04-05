# Homework1

## 1. 
See [README.md](./README.md)

## 2.
git commit -m "new message"

git checkout

git merge 

git rebase main: rebase current base to main

git checkout history-mark: separate head from the history commit

git checkout head^: use after separate head, move the head to previous commit

git checkout main^: the previous commit from main branch

git branch -f main HEAD~3: point main to the third level commit

git reset HEAD~num: used local to reset to previous commits

git revert HEAD~num: use to reset remote branch, first reset and push

git cherry-pick c2 c4: pick commits to current head

git rebase -i HEAD~4: pick several commits and reorder it to commit

## 3. What is the basic steps to init a git repo in you local ?
Create a directory in the local;

Navigate into the directory and type git init.

## 4. How to clone a repo from Github ? 
Get the URL of the remote repository;

Navigate into the directory that you want to clone and type git clone url.

## 5. How to create a new branch and checkout to that branch ? 
Create it directly from gtihub navigate bar and type the new branch and create, or in the command line type git checkout -b new branch name

## 6. How to merge the branch_test to master branch in command ? show me the commands
```
git checkout master
git pull 
git merge branch_test
git push origin master
```
## 7. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to **branch_learn_stash ? try commands way and intellij way
```
git stash

git stash pop
```

## 8. How do you understand PR is based on Branch ?
A PR indicates a branch to review compared to another branch. The system will evaluate how many new commits have been made to the feature branch since the time it has been branched off the Master one.

## 9.  What is maven role ? what it be used to do ? 


