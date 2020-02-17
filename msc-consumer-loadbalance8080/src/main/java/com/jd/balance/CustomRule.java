package com.jd.balance;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//从所有可用的 provider 中排除掉指定端口号的 provider，剩 余 provider 进行随机选择。
public class CustomRule  implements IRule {

    private ILoadBalancer lb;

    //要排除的提供者服务器端口号
    private List<Integer> excludePorts;

    public CustomRule() {
    }

    public CustomRule(List<Integer> excludePorts) {
        this.excludePorts = excludePorts;
    }

    @Override
    public Server choose(Object key) {
        //获取所有可用的server
        List<Server> servers = lb.getReachableServers();
        //获取到排除了指定端口的所有剩余servers
        List<Server> availableServers = getAvailableServers(servers);

        //从剩余servers中随机选择servers
        return getAvailableRandomServer(availableServers);
    }

    private List<Server> getAvailableServers(List<Server> servers) {
        //若没有指定要排除的port，则返回所有server
        if(excludePorts == null || excludePorts.size() == 0){
            return servers;
        }
        //用于存放可用的server
        List<Server> aservers = new ArrayList<>();
        for (Server server : servers) {
            boolean isExclude= false;
            //将当前遍历server端口号与要排除的端口号进行对比
            for (Integer port : excludePorts) {
                if(server.getPort() == port){
                    isExclude = true;
                    break;
                }
            }
            if(!isExclude){
                aservers.add(server);
            }
        }
        return aservers;
    }

    private Server getAvailableRandomServer(List<Server> servers) {
        //获取一个【0，servers.size())的随机整数
        int index = new Random().nextInt(servers.size());
        return servers.get(index);
    }

    @Override
    public void setLoadBalancer(ILoadBalancer lb) {
        this.lb = lb;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return lb;
    }
}
