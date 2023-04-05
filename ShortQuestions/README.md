# Title
1. ```#``` A first-level heading
2. ```##``` A second-level heading
3. ```###``` A third-level heading

# style
1.  ```** **``` **bold**
2. ```* * ```*italic*
3. ```~~ ~~``` ~~Strikethrough~~
4. ```**  _ _  **``` **_Bold_ and nested _italic_**
5. ```<sub> </sub>``` <sub>Subscript</sub>
6. ```<sup> </sup>``` <sup> Superscript </sup>

# Quoting text
```>```  Text that is not a quote
> Text that is a quote

# Quoting code
Some basic Git commands are:
```
Use ``` ``` 
git status
git add
git commit
```

# Supported color models
1. The background color is `#ffffff` for light mode and `#000000` for dark mode.
2. HEX	`#RRGGBB`	`#0969DA`
3. HSL	`hsl(H,S,L)`	`hsl(212, 92%, 45%)`
4. RGB	`rgb(R,G,B)`	`rgb(9, 105, 218)`

>Notes:
A supported color model cannot have any leading or trailing spaces within the backticks.
The visualization of the color is only supported in issues, pull requests, and discussions.

# Links
`[text](docs/CONTRIBUTING.md)`: attach link
[Contribution guidelines for this project](docs/CONTRIBUTING.md)

# Images
`![text](docs/CONTRIBUTING.md)`: attach image
![Screenshot of a comment on a GitHub issue showing an image, added in the Markdown, of an Octocat smiling and raising a tentacle.](https://myoctocat.com/assets/images/base-octocat.svg)

# Lists
## unordered list
```
- George Washington
* John Adams
+ Thomas Jefferson
```

- George Washington
* John Adams
+ Thomas Jefferson

## ordered list
```
1. James Madison
2. James Monroe
3. John Quincy Adams
```

1. James Madison
2. James Monroe
3. John Quincy Adams

## Nested Lists
```
1. First list item
   - First nested list item
     - Second nested list item
```

1. First list item
    - First nested list item
        - Second nested list item

## Task lists
```
- [x] #739
- [ ] https://github.com/octo-org/octo-repo/issues/740
- [ ] Add delight to the experience when all tasks are complete :tada:
```
- [x] #739
- [ ] https://github.com/octo-org/octo-repo/issues/740
- [ ] Add delight to the experience when all tasks are complete :tada:

# Mentioning people and teams
@github/support What do you think about these updates?

# Referencing issues and pull requests
You can bring up a list of suggested issues and pull requests within the repository by typing `#`

# Referencing external resources
If custom autolink references are configured for a repository, then references to external resources, like a JIRA issue or Zendesk ticket, convert into shortened links. To know which autolinks are available in your repository, contact someone with admin permissions to the repository. 

# Uploading assets
You can upload assets like images by dragging and dropping, selecting from a file browser, or pasting. You can upload assets to issues, pull requests, comments, and .md files in your repository.

# Using emoji
You can add emoji to your writing by typing :EMOJICODE:, a colon followed by the name of the emoji.

@octocat :+1: This PR looks great - it's ready to merge! :shipit:

Screenshot of rendered GitHub Markdown showing how emoji codes for +1 and shipit render visually as emoji.

Typing : will bring up a list of suggested emoji. The list will filter as you type, so once you find the emoji you're looking for, press Tab or Enter to complete the highlighted result.

# Paragraphs
You can create a new paragraph by leaving a blank line between lines of text.

# Footnotes
```
Here is a simple footnote[^1].

A footnote can also have multiple lines[^2].

[^1]: My reference.
[^2]: To add line breaks within a footnote, prefix new lines with 2 spaces.
  This is a second line.
```

# Hiding content with comments
`<!-- This content will not appear in the rendered Markdown -->`

# Ignoring Markdown formatting
`Let's rename \*our-new-project\* to \*our-old-project\*.`



