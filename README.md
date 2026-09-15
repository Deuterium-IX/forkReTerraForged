# FreeTerraForged

## D9 简体中文版（Minecraft 1.21.1）

当前定制版本：`0.0.6006-d9.1`。

- 基于上游 `1.21.1` 分支，合入 [PR #232](https://github.com/ETcodehome/FreeTerraForged/pull/232)（`9db96714cea111b560606df4ee6a99a372117937`），修正群岛海岸线与浅滩生成。
- 内置 457 条简体中文翻译，覆盖设置项、悬浮说明、预设、选项值和预览图例。将游戏语言切换为「简体中文」即可使用。
- 支持中文预设名称，以及中文名称的复制、重命名和数据包导出。
- 提供 Fabric 与 NeoForge 构建；使用与你的加载器匹配的一个安装包。

构建需要 JDK 21：

```powershell
.\gradlew.bat :common:test :fabric:build :neoforge:build
```

安装包分别位于 `fabric/build/libs` 和 `neoforge/build/libs`。不要安装 `dev`、`shadow` 或 `sources` JAR。

以下为上游说明。

A community driven fork of the Legendary ReTerraForged project for modern minecraft providing heavily customizable overworld terrain generation.
Additional feature contributions are welcomed via forking and raising a merge PR.

### We stand on the shoulders of giants
- Original project https://github.com/TerraForged/TerraForged
- Builds on the substantial post v1.19+ work of Racoonman2 in https://github.com/racoonman2/ReTerraForged
- Finishes the Neoforge port work started by Equalizer32 in https://github.com/equalizer32/NeoTerraForged/tree/1.21.1

### Licensing 
- Continued under the permissive MIT license as per all historic contributions.

***

# Getting started

### Customize a new world
<img width="856" height="526" alt="image" src="https://github.com/user-attachments/assets/941bc4b1-9334-4c08-9197-9ff729876369" />

---

### Select a preset 
<img width="1186" height="754" alt="image" src="https://github.com/user-attachments/assets/65a8e11e-1d76-42ce-bfd5-9fd34c9adfda" />

- Use existing settings directly via [Done]
- Customize the selected preset via [>>]
- Copy or create fresh presets using the right hand menu

---

### Customize your world
<img width="3840" height="2100" alt="image" src="https://github.com/user-attachments/assets/0b053a98-c8ec-4b92-b6ad-8dfc41eacf8a" />

- There are many pages of settings accessible via paging through using [<<] and [>>]
- Click Done to save your edits.
- Click Cancel to abandon your edits.

---

# Bugs
- Any issues encountered should be raised as Github issues with as much supporting documentation as you can provide, ideally latest.log and screenshots at a minimum.
