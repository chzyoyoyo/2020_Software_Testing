import angr
import claripy


proj = angr.Project("guest", load_options={'auto_load_libs':False})


argv1 = claripy.BVS("argv1",50*8)
state = proj.factory.entry_state(args=["./guest",argv1])
# print(hex(proj.entry))

# block = proj.factory.block(proj.entry)

# block.pp()


simgr = proj.factory.simulation_manager(state)

# print(simgr.active)

# print(simgr.step())

# print(simgr.active)
avoid_addr = 0x4005a7
find_addr = 0x4005c1

simgr.explore(find=find_addr, avoid=avoid_addr)

found = simgr.found[0] 
print(found)
solution = found.solver.eval(argv1, cast_to=bytes)

print(repr(solution))
solution = solution[:solution.find(b"\x00")]
print(solution)
