PROBLEM  STATEMENT:
Write a program for computing block addresses, given one IP address and Mask.
INTRODUCTION:
Layer-3 in the OSI model is called Network layer. Network layer manages options pertaining to host and network addressing, managing sub-networks, and internetworking.
Network Layer:
Network addressing is one of the major tasks of Network Layer. Network Addresses are always logical i.e. these are software based addresses which can be changed by appropriate configurations. It always points to host / node / server or it can represent a whole network. Network address is always configured on network interface card and is generally mapped by system with the MAC address (hardware address or layer-2 address) of the machine for Layer-2 communication.
IPv4 address:
Every host and router on internet has an IP address which encodes its network number and host number, combination of the two is unique. An IP address does not actually refer to a host but refers to a network interface, so if host is on two networks, it must have two IP addresses. IP addresses are 32 bits made up of four octets of 8 bits each.
Default Mask:
An address mask determines which portion of an IP address represents network number and which part represents host number, e.g., IP address, the mask has four octets. If a given bit of the mask is 1, the corresponding bit of the IP address is in network portion and if given bit of mask is 0, the corresponding bit of IP address is in host portion. 

CIDR:
Classless Inter Domain Routing uses slash(/) notation to specify the mask with IPv4 address. The address is given as x.y.z.t/n where x.y.z.t is the IP address and n is the number of 1’s in the default mask.
Network address:
First address of a network is network address. It is obtained by ANDing the mask with the IP address (Both in binary form). Another method is to set last 32-n bits of the IP address to 0.
Broadcast address:
Last address of a network is broadcast address. It is obtained by ORing the complement mask with the IP address(Both in binary form). Another method is to set last 32-n bits of the IP address to 1.
Class:
Class of an address is identified by the first byte of address. There are currently five classes A, B, C, D and E. The range of first byte of each class is:
•	Class A: 0 – 127
•	Class B: 128 – 191
•	Class C: 192 – 223
•	Class D: 224 – 239
•	Class E: 240 - 255
Algorithm of the code
1.	Input CIDR address (IPv4+mask address)in the format (x.y.z.t/n)
2.	Convert IP address into Binary format
3.	Convert mask address into Binary format.
4.	Calculate the default mask using the formula n=32-s, where s is the number of ones  in subnet mask.
5.	Find the first address i.e Network address by setting last n bits of IP address to 0.
6.	Find the last address i.e Broadcast address by setting last n bits of IP address to 1.
