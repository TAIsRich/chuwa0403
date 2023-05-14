# Markdown Basics
## Headings
\# represents first level heading;

\## represents second level heading;

\### represents third level heading.

## Creating a table
Use | to separate each colomn;

Use ----- to separate headers and contents;

## Styling text
| Style | Syntax|
|------|-----------|    
|     Bold| \** \** or \__ \__ |
|     Italic| \* \* or \_ \_    |   
|     Strikethrough| \~~ \~~       | 
| All bold and italic| \*** \*** |
| Subscript| \<sub> \</sub> |

Bold and italic can be used nested

## Quoting 
Use \`  \` to call out code within a sentence

e.g. `git status`

Use \``` \``` to format code or texts into its own block

```
git status
git add
git commit
```

## Color models
| Color | Syntax|
|------|-----------|    
|     HEX| `#RRGGBB` |
|     RGB| `rgb(R,G,B)`    |   
|     Strikethrough| `hsl(H,S,L)` | 

## Links 
Create an inline link by wrapping link text in brackets [ ], and then wrapping the URL in parentheses ( ). The url could either be a website or a relative path to your repo.

e.g. This site was built using [GitHub Pages](https://pages.github.com/).

## Images
Display an image by adding ! and wrapping the alt text in [ ]. Alt text is a short text equivalent of the information in the image. Then, wrap the link for the image in parentheses ().

e.g. ![Screenshot](https://user-images.githubusercontent.com/25423296/163456779-a8556205-d0a5-45e2-ac17-42d089e3c3f8.png)

Relative links of an image
| Context | Relative Link|
|------|-----------|    
|     In a .md file on the same branch| /assets/images/electrocat.png |
|     In a .md file on another branch| /../main/assets/images/electrocat.png    |   
|     In a .md file in another repository| /../../../../github/docs/blob/main/assets/images/electrocat.png |

## Lists
Make an unordered list by preceding one or more lines of text with -, *, or +.

### Nested Lists
Type space characters in front of your nested list item until the list marker character (- or *) lies directly below the first character of the text in the item above it.

### Tasks Lists
To create a task list, preface list items with a hyphen and space followed by [ ]. To mark a task as complete, use [x].

e.g.
- [x] Add Readme.md

## Mentioning people and team
Mention a person or team on GitHub by typing @ plus their username or team name. @Jakob1357
