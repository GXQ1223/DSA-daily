# Last updated: 9/19/2025, 10:34:28 PM
class Router:

    def __init__(self, memoryLimit: int):
        self.memoryLimit = memoryLimit
        self.q = []
        self.packet_set = set()
        self.map = {}
        

    def addPacket(self, source: int, destination: int, timestamp: int) -> bool:
        if (timestamp, source, destination) in self.packet_set:
            # print("(timestamp, source, destination) in self.packet_set")
            return False
        self.q.append((timestamp, source, destination))
        if self.map.get(destination) is None:
            self.map[destination] = []
        self.map[destination].append(timestamp)
        self.packet_set.add((timestamp, source, destination))
        if len(self.q) > self.memoryLimit:
            a, b, destination = self.q.pop(0)
            self.map[destination].pop(0)
            self.packet_set -= {(a, b, destination)}
        # print("q: ", self.q)
        # print("map", self.map)
        return True

    def forwardPacket(self) -> List[int]:
        # print("forwardPacket: ", self.q)
        if not self.q:
            return []
        timestamp, source, destination = self.q.pop(0)
        # print("destination: ", destination)
        self.map[destination].pop(0)
        self.packet_set -= {(timestamp, source, destination)}

        return [source, destination, timestamp]
        

    def getCount(self, destination: int, startTime: int, endTime: int) -> int:
        if self.map.get(destination) is None:
            return 0
        lst = self.map[destination]
        # print("lst: ", lst)
        l,r = 0, len(lst) - 1
        # find first timestamp 
        while l <= r:
            m = (l+r)//2
            if lst[m] >= startTime:
                r = m-1
            else:
                l = m+1
        left = r
        # print("left: ", left)
        # find 2nd timestamp
        l,r = 0, len(lst) - 1
        while l <= r:
            m = (l+r)//2
            if lst[m] <= endTime:
                l = m+1
            else:
                r = m-1
        right = r
        # print("right: ", right)
        return right - left

        


# Your Router object will be instantiated and called as such:
# obj = Router(memoryLimit)
# param_1 = obj.addPacket(source,destination,timestamp)
# param_2 = obj.forwardPacket()
# param_3 = obj.getCount(destination,startTime,endTime)