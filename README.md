# Chain Suspension

[![GitHub release](https://img.shields.io/github/release/haykam821/Chain-Suspension.svg?style=popout&label=github)](https://github.com/haykam821/Chain-Suspension/releases/latest)
[![CurseForge](https://img.shields.io/static/v1?style=popout&label=curseforge&message=project&color=6441A4)](https://www.curseforge.com/minecraft/mc-mods/chain-suspension)
[![Discord](https://img.shields.io/static/v1?style=popout&label=chat&message=discord&color=7289DA)](https://haykam.com/links/discord)

Allows suspending gravity-affected blocks from chains.

Chain Suspension requires the [Fabric modloader](https://fabricmc.net/use/).

## Installation

1. Download Chain Suspension from [CurseForge](https://www.curseforge.com/minecraft/mc-mods/chain-suspension/files) or [GitHub](https://github.com/haykam821/Chain-Suspension/releases).
2. Place the downloaded file in your `mods` folder.

## Usage

When this mod is installed, gravity-affected blocks such as sand, gravel, concrete powder, anvils, and dragon eggs will not fall when placed under a vertical chain.

Any block in the `#chainsuspension:unsuspendable_blocks` tag will fall even if it is below a vertical chain.

Any block in the `#chainsuspension:suspension_blocks` tag will prevent gravity-affected blocks from falling. Regardless of their presence in this tag, vertical chains will prevent gravity-affected blocks from falling.
