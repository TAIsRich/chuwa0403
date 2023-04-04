# Markdown Learning

## 1. Headings

We use `#` to create different level of headings.

```text
# A first-level heading
## A second-level heading
### A third-level heading
```

## 2. Styling Text

| Style                  | Syntax         | Example                                  | Outcome                                |
|:-----------------------|:---------------|:-----------------------------------------|:---------------------------------------|
| Bold                   | ** ** or __ __ | `**This is bold text**`                  | **This is bold text**                  |
| Italic                 | * * or _ _     | `*This is italic text*`                  | *This is italic text*                  |
| Strikethrough          | ~~ ~~          | `*~~This was mistaken text~~`            | ~~This was mistaken text~~             |
| Bold and nested italic | ** ** and _ _  | `**This text is _extremely_ important**` | **This text is _extremely_ important** |
| All bold and italic    | *** ***        | `***All this text is important***`       | ***All this text is important***       |
| Subscript              | <sub> </sub>   | `<sub>This is a subscript text</sub>`    | <sub>This is a subscript text</sub>    |
| Superscript            | <sup> </sup>   | `<sup>This is a superscript text</sup>`  | <sup>This is a superscript text</sup>  |

## 3. Quoting Text

We can use a `>` to start a quote text part.
> This is a line of quote text.

## 4. Quoting Code

1. Inline quote: use ``  
`Inline quote`
2. Block quote: use ``````  
```Block quote```

## 5. Supported Color Models
---
| Color | Syntax         | Example                | Output                                                       |
| :---- | :------------- | :--------------------- | :----------------------------------------------------------- |
| HEX   | ``#RRGGBB``    | ``#0969DA``            | ![Screenshot of rendered GitHub Markdown showing how HEX value #0969DA appears with a blue circle.](https://docs.github.com/assets/cb-1560/images/help/writing/supported-color-models-hex-rendered.png) |
| RGB   | ``rgb(R,G,B)`` | ``rgb(9, 105, 218)``   | ![Screenshot of rendered GitHub Markdown showing how RGB value 9, 105, 218 appears with a blue circle.](https://docs.github.com/assets/cb-1962/images/help/writing/supported-color-models-rgb-rendered.png) |
| HSL   | ``hsl(H,S,L)`` | ``hsl(212, 92%, 45%)`` | ![Screenshot of rendered GitHub Markdown showing how HSL value 212, 92%, 45% appears with a blue circle.](https://docs.github.com/assets/cb-2068/images/help/writing/supported-color-models-hsl-rendered.png) |
The background color is `#ffffff` for light mode and `#000000` for dark mode.

## 6. Links

Use [ ] to wrap the link text, and then wrapping the URL in parentheses ( ).    
This site was built using [GitHub Pages](https://pages.github.com/).

## 7. Images

You can display an image by adding ! and wrapping the alt text in [ ]. Alt text is a short text equivalent of the information in the image. Then, wrap the link for the image in parentheses ().

`![alt text](Picture URL)`

## 8. Lists

1. unordered list
Use `-`, `*`, or `+`.
2. ordered list
Use numbers `1.`, `2.`, `3.`, ... 

