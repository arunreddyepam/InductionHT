GIT HOME TASK ANSWERS



\--------------------------------------------------

LOW-LEVEL QUESTIONS

\--------------------------------------------------



1\. Initialize a new Git repository and make the first commit



Steps:

\- Navigate to project folder:

&#x20; cd your-folder-name



\- Initialize a Git repository:

&#x20; git init



\- Create the file and add content:

&#x20; echo "Hello, Git!" > test.txt



\- Add the file to staging:

&#x20; git add test.txt



\- Commit the file:

&#x20; git commit -m "Initial commit with test.txt"





\--------------------------------------------------



2\. View modified files and detailed commit history



\- To check modified files:

&#x20; git status



\- To see changes in files:

&#x20; git diff



\- To view commit history:

&#x20; git log



\- For a more detailed/compact view:

&#x20; git log --oneline --graph --decorate





\--------------------------------------------------



3\. Clone a repository from a Git server



\- Get the repository URL (HTTPS or SSH).

\- Clone repo:

&#x20; git clone https://github.com/user/repo.git



\- Navigate into folder:

&#x20; cd repo





\--------------------------------------------------

MEDIUM-LEVEL QUESTIONS

\--------------------------------------------------



4\. Work on feature branch (feature-login)



Create branch from master



\- git checkout master

&#x20; git pull origin master   # ensure it's up to date



\- Create branch:

&#x20; git checkout -b feature-login



\- Make changes and commit:

&#x20; git add .

&#x20; git commit -m "Add login feature"



\- Check branch status:

&#x20; git status



\- To confirm current branch:

&#x20; git branch





\--------------------------------------------------



5\. Merge feature-navbar into master



\- Switch to master:

&#x20; git checkout master



\- Pull latest:

&#x20; git pull origin master



\- Merge branch:

&#x20; git merge feature-navbar



\- Resolve conflicts:

&#x20; Edit files and remove conflict markers



\- Add resolved files:

&#x20; git add .



\- Complete merge:

&#x20; git commit





\--------------------------------------------------



6\. Rebasing feature branch onto updated master



\- Switch to feature branch:

&#x20; git checkout feature-login



\- Fetch updates:

&#x20; git fetch origin



\- Rebase:

&#x20; git rebase origin/master



\- Resolve conflicts if any:

&#x20; git add .

&#x20; git rebase --continue



\- Abort if needed:

&#x20; git rebase --abort



Merge vs Rebase (Key Differences)



Merge:

* Keeps full history
* Creates a merge commit
* Safe for shared branches



Rebase:

* Creates linear history
* Rewrites commit history
* Cleaner but risky if shared



When to use what?



Use Merge when:

* Working in a team
* Branch is shared
* Want full history preserved

Use Rebase when:

* Cleaning up your commits
* Working on your own branch
* Want a linear history



\--------------------------------------------------

COMPLEX-LEVEL QUESTIONS

\--------------------------------------------------



7\. Use git stash and cherry-pick



Scenario:



You’re working on feature-login, but suddenly need to fix a critical bug on master.



\- Using git stash:

&#x20; Save unfinished work

&#x20; - git stash

&#x20;   This stores your changes without committing them.



&#x20; - Switch branch:

&#x20;   git checkout master



&#x20; - Fix bug and commit:

&#x20;   git add .

&#x20;   git commit -m "Hotfix"



&#x20; - Return and restore:

&#x20;   git checkout feature-login

&#x20;   git stash pop



\-Using git cherry-pick:



&#x20; If you want a specific commit from another branch:

&#x20;  git cherry-pick <commit-hash>



\--------------------------------------------------



8\. Reverting a faulty commit (without breaking history)



\- Find commit:

&#x20; git log



\- Revert:

&#x20; git revert <commit-hash>



Note:

\- This creates a new commit that undoes the changes.

\- Keeps history intact





\--------------------------------------------------



9\. Setup pre-commit hook

&#x20;

&#x20;What is a pre-commit hook?



&#x20;A pre-commit hook is a script that runs automatically before a commit is finalized. It can check code quality, run tests, or enforce rules so that only     valid code is committed.



How to set it up

Step 1: Navigate to the hooks folder



\- Navigate:

&#x20; cd .git/hooks



\-Create or edit the pre-commit file:

&#x20; touch pre-commit

&#x20; chmod +x pre-commit



\- Add linting script:

&#x20; #!/bin/sh

&#x20; npm run lint



Why set this up in a shared workflow:



* Consistency: Ensures all developers follow the same coding standards
* Early detection: Prevents bad code or formatting from entering the repository
* Automated enforcement: Reduces manual code reviews for style issues



Impact on code quality:



* Improves readability and maintainability of the codebase
* Reduces bugs caused by code style errors
* Helps maintain a cleaner commit history



\--------------------------------------------------



10\. Investigating and Fixing a Bug from Commit abc123



Description:

Use Git commands to identify when a bug was introduced and fix it without breaking history.



Workflow:



\- Examine the problematic commit:

git show abc123

\# Shows the diff, files changed, and commit message to understand the bug.



\- View recent commits for context (optional):

git log --oneline --graph --decorate -n 5



\- Use git bisect to identify the first bad commit (if unsure):

git bisect start

git bisect bad               # current commit has the bug

git bisect good HEAD\~10      # last known good commit



\# Git checks out a commit in the middle. Test the code:

\# If bug exists:

git bisect bad

\# If bug does not exist:

git bisect good



\# Repeat until Git identifies the first bad commit.



\- Create a branch to fix the bug:

git checkout -b fix-bug-abc123



\- Edit the code to fix the bug.



\- Stage and commit the fix:

git add .

git commit -m "Fix bug introduced in commit abc123"



\- Test thoroughly to ensure bug is fixed and no other issues exist.



\- Finish bisecting (if used):

git bisect reset



\- Merge the fix into main branch:

git checkout main

git pull origin main

git merge fix-bug-abc123

git push origin main



Summary:

\- git show: inspect commit

\- git log: check context

\- git bisect: find first bad commit

\- Branch, fix, commit, test

\- Merge fix safely into main branch



\--------------------------------------------------



11\. Maintaining a Clean Commit History Using Git Rebase



Description:

Use git rebase to edit, rearrange, squash, or split commits for a clean and concise history.



Workflow:



1\. Start an interactive rebase for the last N commits:

git rebase -i HEAD\~3

\# Opens an editor showing the last 3 commits.



2\. Rebase commands in the editor:

\- pick   → keep commit as-is

\- reword → edit commit message

\- squash → combine this commit with the previous one

\- edit   → pause to modify commit content

\- fixup  → squash commit without keeping its message



3\. Rearrange commits:

\- Move lines up/down in the editor to change commit order.



4\. Squash commits:

\- Replace 'pick' with 'squash' for commits to combine with the previous one.



5\. Split a commit:

\- Mark the commit with 'edit'

git add .

git reset HEAD^

\# Now stage portions separately

git commit -m "Partial commit 1"

git commit -m "Partial commit 2"

git rebase --continue



6\. Resolve conflicts if any:

\- Edit files

\- git add .

\- git rebase --continue



7\. Abort rebase if needed:

git rebase --abort



Notes:

\- Interactive rebase rewrites commit history, so avoid rebasing shared branches.

\- Keeps commit history clean, concise, and readable for reviewers.



\--------------------------------------------------



12\. Fork and create pull request



\- Fork repo (GitHub)



\- Clone fork:

&#x20; git clone https://github.com/your-username/repo.git



\- Add upstream:

&#x20; git remote add upstream https://github.com/original/repo.git



\- Create branch:

&#x20; git checkout -b feature-fix



\- Commit changes:

&#x20; git add .

&#x20; git commit -m "Fix issue"



\- Push:

&#x20; git push origin feature-fix



\- Create Pull Request on GitHub



Best Practices:

\- Keep fork updated:

&#x20; git pull upstream master

\- Write clear commits





\--------------------------------------------------



END OF DOCUMENT

