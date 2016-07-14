package client.gui.crudPanel;

import java.util.List;
import java.util.stream.Collectors;

import client.App;
import client.bean.CrudBlock;
import client.rmiclient.classes.crud.ExtendedCrudPanel;
import client.rmiclient.classes.crud.ModelHolder;
import client.utils.MessageUtils;
import client.utils.ProgressBar;
import client.utils.ProgressBar.ProgressBarListener;
import desktopadmin.action.bean.BlockBean;
import desktopadmin.model.building.Block;

public class BlockCrudPanel extends ExtendedCrudPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -897114854988642360L;

	public BlockCrudPanel( )
	{
		super("Block");
	}

	@Override
	protected void fillCrudTable( )
	{
		ProgressBar.execute(new ProgressBarListener<BlockBean>()
		{

			@Override
			public BlockBean onBackground( ) throws Exception
			{
				return App.getCrudService().getBlockBean();
			}

			@Override
			public void onDone(BlockBean response)
			{
				crudPanel.fillValues(
						new ModelHolder(
								response.getBlocks().stream().map(
										e -> CrudBlock.fromBlock(e)).collect(Collectors.toList()
												), 
												CrudBlock.class));
				 
				crudPanel.getBeanComplexElement().addObjects("project",response.getProjects() );

			}
		}, this);

	}

	@Override
	public void initComponents( )
	{
		super.initComponents();
		
		btnClose.setVisible(true);
	}

	@Override
	protected void btnCancelAction( )
	{
		// TODO Auto-generated method stub

	}

	@Override
	protected void btnSaveAction( )
	{
		ProgressBar.execute(new ProgressBarListener<Void>()
		{

			@Override
			public Void onBackground( ) throws Exception
			{
				List<CrudBlock> crudBlocks = crudPanel.getResult(CrudBlock.class);
				List<Block> blocks = crudBlocks.stream().map(e->e.toBlock()).collect(Collectors.toList());
				
				
				App.getCrudService().saveOrUpdate(blocks);
				return null;
			}

			@Override
			public void onDone(Void response)
			{
				MessageUtils.showInfoMessage(BlockCrudPanel.this, "Data saved");
				
			}
		}, this);

	}

}
