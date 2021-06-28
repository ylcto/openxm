package cn.xmjar.utils;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <li>此类用于定义公共接口方法</li>
 * @author 欣茂Java网络课堂开源组件 xmjar.cn
 * @param <K> 表示对象主键类型
 * @param <V> 表示对象
 */
public interface IDAO<K, V> {

    /**
     * <li>此类主要负责对象数据增加</li>
     * @param vo 表示要执行增加的对象
     * @return 增加成功返回true,增加失败返回false
     */
    public boolean doCreate(V vo);

    /**
     * <li>此类主要负责对象数据更新</li>
     * @param vo 表示要执行更新的对象
     * @return 更新成功返回true,更新失败返回false
     */
    public boolean doUpdate(V vo);

    /**
     * 根据主键删除行记录
     * @param id 表示要执行删除的对象主键
     * @return 删除成功返回true，删除失败返回false
     */
    public boolean doRemove(K id);

    /**
     * <li>此方法是执行批量删除数据行记录</li>
     * @param ids
     * @return
     */
    public boolean doRemoveBatch(Set<K> ids);

    /**
     * <li>根据编号查询数据行</li>
     * @param id 表示要执行数据查询的主键
     * @return 查询成功返回该行数据，查询失败返回null
     */
    public V findById(K id);

    /**
     * <li>查询对象中所有数据，在数据量大的情况下不建议使用</li>
     * @return 查询成功返回全部数据，查询失败返回null
     */
    public List<V> findAll();

    /**
     * <li>此方法用于数据模糊查询与分页实现</li>
     * @param params 包含 int currentpage ，int lineSize ,String keyWord,String column,具体分页与模糊查询由用户决定
     * @return 查询成功返回全部数据，查询失败返回null
     */
    public List<V> findAllBySplit(Map<String,Object> params);
    /**
     * <li>此方法用于数据统计</li>
     * @param params 包含 String keyWord,String column
     * @return 查询成功返回数据量，查询失败返回0
     */
    public Integer getAllCountBySplit(Map<String,Object> params);
    /**
     * <li>此方法用于数据统计</li>
     * @return 查询成功返回数据量，查询失败返回0
     */
    public Integer getAllCount();
}
