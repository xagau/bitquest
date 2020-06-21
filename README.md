# PHL BitQuest

[BitQuest](http://bitquest.co/) is a Minecraft mod that connects the game economics to a  PHL / Bitcoin or other cryptocurrency nodes. It creates a PHL wallet for every user that connects to the server, plus a common "loot" wallet used for rewards to players when killing mobs.

Players also can purchase land plots and stacks of items, transferring coins to the loot wallet, thus redistributing the spent cryptocurrency within the players.

You can use BitQuest to host your own Minecraft crypto server.

# Official Servers

* TBA

# Important Note
This project is an experiment and not a commercial product, bugs can, and most likely will happen. Please report any bugs to a moderator promptly, to ensure they are fixed. Also note that your wallet is not guaranteed, and you may experience issues with your balance. For this reason, it is highly recommended that you do not deposit large amounts, or anything you do not wish to place at risk by being tied to the server. In addition, if you are caught breaking rules and are banned, you forfeit your access to your server wallet, and all funds tied to it. With this said, rules are non-negotiable, and will be strictly enforced. This server is a fair server, and anyone abusing any system set in place will be punished. Please play fair, have fun, and enjoy the server

# How it works?
## Everyone is a Bitcoin wallet
The [BitQuest](https://bitquest.co/) server and every player has a bitcoin address. Any player can receive and send bitcoin to any address inside or outside the game. This is useful for buying materials, selling crafts, trading, tipping, etcetera.
![A player just joined the server](http://i.imgur.com/1A6wkaB.png)
![The playercan see it's bitcoin balance](http://i.imgur.com/5g5pBXB.png)

## And there's loot!
Every time a player kills an enemy (mob) there is a chance to get loot. If that is the case the server makes a transaction directly from the server address to the player address and the player is notified.
![A player got loot](http://i.imgur.com/cxqXmt2.png)

## Everyone can send money anywhere
You can send Bitcoin to an external wallet with /transfer:
```
/transfer <amount> <recipient-bitcoin-address>
```
![Player using transfer command](http://i.imgur.com/Vlf9C1F.png)
![Player notification](http://i.imgur.com/PHmomoS.png)
![Player's public transaction](http://i.imgur.com/JPO4AXt.png)  

Additionally, players can send Bitcoin to other players via /send:
```
/send <amount> <username>
```

## Server address
The BitQuest server has it's own address, used for giving Loot to players.

# Building the BitQuest Java Plugin
You can build the bitquest Java plugin if you wantt to contibute to the code (all pull requests are welcome) or if you want to run your own server.

## 1. Requirements

1. Java JRE+SDK (Version 1.8)
2. Maven


## 2. Compile BitQuest and generate a JAR file
There is a maven project that will download the spigot 1.12.2 (downloading the latest version will be automated in future):

```sh
mvn package -B
```

Or using all of your cpu core (fastest)
(If you have low ram your build can crash)
```sh
mvn package -B -T 1C
```

# Contibuting
Before submitting a pull request, please format the code in google style.
You can easly format the code by doing (you can exec this script from anywhere (you can do ../../../../../build.sh if you where on src/java/main/bitquest/bitquest/)):

```sh
./format.sh
```

# Running a BitQuest server with Docker

Tou can use Docker to run a BitQuest server. There's also an [official BitQuest docker image](https://hub.docker.com/r/bitquest/bitquest/). The recommended way to configure the image is using a docker-compose.yml file that can link to a directory where the worlds are stored. An example is included here. 

## Configuration

Configuration can be done via enviroment variables:

| environment variable            | description                                                            |
|---------------------------------|------------------------------------------------------------------------|
| ADMIN_UUID                      | Minecraft user ID for the main administrator                           |
| BLOCKCYPHER_CHAIN               | btc/main for bitcoin mainnet. btc/test3 for bitcoin testnet            |
| POSTGRES_ENV_POSTGRES_USER      | Username for connecting to the PostgreSQL database                     |
| POSTGRES_1_PORT_5432_TCP_ADDR   | Address of DB server                                                   | 
| POSTGRES_1_PORT_5432_TCP_PORT   | Port for the DB server                                                 |
| POSTGRES_1_PORT_5432_TCP_DBNAME | Name of the database to be used                                        |

# More info

https://bitquest.co/
